/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright ⓒ2021 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package com.study.chapter1;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Invoice {
    public String customer;
    public List<Performance> performances = new ArrayList<>();
}
