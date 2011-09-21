/*
 * @(#)ObjectNotFoundException
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
package com.spartan.springmvc.exception;

@SuppressWarnings("serial")
public class FacebookSignatureVerificationFailedException extends Exception {

	public FacebookSignatureVerificationFailedException() {
        // TODO Auto-generated constructor stub
    }
    
    public FacebookSignatureVerificationFailedException(String message) {
        super(message);
    }
    
    public FacebookSignatureVerificationFailedException(Throwable e) {
        super(e);
    }
    
    public FacebookSignatureVerificationFailedException(String message, Throwable e) {
        super(message, e);
    }
}
