/*
 * @(#)FacebookSignatureModel
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
package com.spartan.springmvc.model;

import org.codehaus.jackson.annotate.JsonProperty;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

/**
 * Model for a Facebook Page signature.
 * Example json: 
 * { 
 *     "app_data" : "XXXXXXXXXXXXX",
 *     "algorithm" : "HMAC-SHA256",
 *     "expires" : 0,
 *     "issued_at" : 1306261336,
 *     "oauth_token" : "107483109317506|e4f1f69af49edc3d2d3a9d82.0-100001618924644|JUm9BAxcc6fSOrcGOecwuKo8xMw",
 *     "page" : { "admin" : true,
 *         "id" : "153458858034656",
 *         "liked" : false
 *       },
 *     "user" : { "age" : { "min" : 21 },
 *         "country" : "us",
 *         "locale" : "en_US"
 *       },
 *     "user_id" : "100001618924644"
 * }
 * 
 * 
 * @author  jhannus
 * @version sclp-webapp: Jul 28, 2011
 */
public class FacebookPageRequestModel {

    public static class User {
        public User() {
        }
        
        @BusinessKey(required=false)
        private String locale;
        @BusinessKey(required=false)
        private String country;

        public String getCountry() {
            return country;
        }
        @JsonProperty("country")
        public void setCountry(String country) {
            this.country = country;
        }
        public String getLocale() {
            return locale;
        }
        @JsonProperty("locale")
        public void setLocale(String locale) {
            this.locale = locale;
        }
        @Override
        public int hashCode() {
            return BusinessIdentity.getHashCode(this);
        }
        @Override
        public boolean equals(Object obj) {
            return BusinessIdentity.areEqual(this, obj);
        }
        @Override
        public String toString() {
            return "User [locale=" + locale + ", country=" + country + "]";
        }
        
    }
    public static class Page {
        public Page() {
        }
        public Page(String id) {
            this.id = id;
        }
        
        @BusinessKey(required=false)
        private String id;
        @BusinessKey(required=false)
        private Boolean admin;
        @BusinessKey(required=false)
        private Boolean liked;
        
        public String getId() {
            return id;
        }
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }
        public Boolean isAdmin() {
            return admin;
        }
        @JsonProperty("admin")
        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }
        public Boolean isLiked() {
            return liked;
        }
        @JsonProperty("liked")
        public void setLiked(Boolean liked) {
            this.liked = liked;
        }
        @Override
        public int hashCode() {
            return BusinessIdentity.getHashCode(this);
        }
        @Override
        public boolean equals(Object obj) {
            return BusinessIdentity.areEqual(this, obj);
        }
        @Override
        public String toString() {
            return "Page [id=" + id + ", admin=" + admin + ", liked=" + liked
                    + "]";
        }
        
    }
    
    @BusinessKey(required=false)
    private String appData;
    @BusinessKey(required=false)
    private Integer issuedAt;
    @BusinessKey(required=false)
    private String expires;
    @BusinessKey(required=false)
    private String oauthToken;
    @BusinessKey(required=false)
    private String userId;
    @BusinessKey(required=false)
    private String algorithm;
    @BusinessKey(required=false)
    private User user;
    @BusinessKey(required=false)
    private Page page;

    public FacebookPageRequestModel() {
    }
    public FacebookPageRequestModel(String userId) {
        this.userId = userId;
    }
    
    public String getAppData() {
        return appData;
    }
    @JsonProperty("app_data")
    public void setAppData(String appData) {
        this.appData = appData;
    }
    public Integer getIssuedAt() {
        return issuedAt;
    }
    @JsonProperty("issued_at")
    public void setIssuedAt(Integer issuedAt) {
        this.issuedAt = issuedAt;
    }
    public String getExpires() {
        return expires;
    }
    @JsonProperty("expires")
    public void setExpires(String expires) {
        this.expires = expires;
    }
    public String getOauthToken() {
        return oauthToken;
    }
    @JsonProperty("oauth_token")
    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }
    public String getUserId() {
        return userId;
    }
    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getAlgorithm() {
        return algorithm;
    }
    @JsonProperty("algorithm")
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
    public User getUser() {
        return user;
    }
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }
    public Page getPage() {
        return page;
    }
    @JsonProperty("page")
    public void setPage(Page page) {
        this.page = page;
    }
    @Override
    public int hashCode() {
        return BusinessIdentity.getHashCode(this);
    }
    @Override
    public boolean equals(Object obj) {
        return BusinessIdentity.areEqual(this, obj);
    }
    @Override
    public String toString() {
        return "FacebookSignatureModel [appData=" + appData + ", issuedAt="
                + issuedAt + ", expires=" + expires + ", oauthToken="
                + oauthToken + ", userId=" + userId + ", algorithm="
                + algorithm + ", user=" + user + ", page=" + page + "]";
    }
    
}
