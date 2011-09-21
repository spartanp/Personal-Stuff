/*
 * @(#)FacebookSignedRequest
 *
 * Copyright 2011 by Constant Contact Inc.,
 * Waltham, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 *
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 * 
 * History
 *
 * Date         Author      Comments
 * ====         ======      ========
 *
 * 
 **/
package com.spartan.springmvc.bean;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.spartan.springmvc.exception.FacebookSignatureVerificationFailedException;

@Component
public class FacebookSignatureBean {

    private static final Logger logger = Logger.getLogger(FacebookSignatureBean.class);
    
    public FacebookSignatureBean() {
        
    }
    
    /**
     * Parses and verifies a Facebook signed_request parameter. The data of the signed request is returned on successful verification.
     *
     * @param signedRequest
     * @param appSecret
     * @return 
     * @return
     * @throws FacebookSignatureVerificationFailedException
     */
    @SuppressWarnings("unchecked")
    public <T> T parseSignature(String signedRequest, String appSecret, Class<T> clazz) throws FacebookSignatureVerificationFailedException {
        
        String[] parts = signedRequest.split("\\.");
        if (parts.length != 2) {
            throw new FacebookSignatureVerificationFailedException("Invalid signature format.");
        }

        String encSig = parts[0];
        String encPayload = parts[1];
        Base64 decoder = new Base64(true);

        try {
            Mac mac = Mac.getInstance("HMACSHA256");
            mac.init(new SecretKeySpec(appSecret.getBytes(), mac.getAlgorithm()));
            byte[] calcSig = mac.doFinal(encPayload.getBytes());
            byte[] decodedSig = decoder.decode(encSig);
            boolean isVerified = Arrays.equals(decodedSig, calcSig);
            
            if (isVerified) {
                try {
                    String unsignedData = new String(decoder.decode(encPayload));
                    logger.debug("unsignedData: " + unsignedData);
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    T data = mapper.readValue(unsignedData, (Class<T>)clazz);
                    return data;
                } catch (IOException e) {
                    throw new FacebookSignatureVerificationFailedException("Failed to parse JSON data: " + e.getMessage(), e);
                }
            } else {
                throw new FacebookSignatureVerificationFailedException("Signatures do not match.");
            }
            
        } catch (NoSuchAlgorithmException e) {
            throw new FacebookSignatureVerificationFailedException(e);
        } catch (InvalidKeyException e) {
            throw new FacebookSignatureVerificationFailedException(e);
        }
    }

}
