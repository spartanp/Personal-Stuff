package com.spartan.springmvc;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spartan.springmvc.bean.FacebookSignatureBean;
import com.spartan.springmvc.model.FacebookPageRequestModel;

@Controller
@RequestMapping(value = "/fb")
public class FbController {
    private Logger logger = Logger.getLogger(this.getClass());
    
    @Autowired
    private FacebookSignatureBean facebookSignatureBean;
    
    private String facebookAppSecret = "407b10911a5af73dbbc008e4b027dc2e";
    
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        logger.info("facebook request came in");
        return "hello_get";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String displayTabPost(@RequestParam(value="signed_request") String signedRequest, ModelMap model, HttpServletResponse response) throws Exception {

        // if the signature parse fails this will throw and be caught by the exception handler. error view is shown...
        FacebookPageRequestModel fbData = facebookSignatureBean.parseSignature(signedRequest, 
                facebookAppSecret, FacebookPageRequestModel.class);
        FacebookPageRequestModel.Page fbPage = fbData.getPage();
        if (fbPage == null) {
            // no page data? shouldn't happen but we don't trust Facebook...
            logger.error("Facebook signed_request does not contain a Page object.");
            return "fberror";
        }
        
        model.put("isCurrentAdmin", fbPage.isAdmin());
        model.put("isLikedByUser", fbPage.isLiked());
        if (fbPage.getId() == null) {
            // no page data? shouldn't happen but we don't trust Facebook...
            logger.error("Facebook signed_request Page object does not contain an ID.");
            return "fberror";
        }
        
        return "hello";
    }

}
