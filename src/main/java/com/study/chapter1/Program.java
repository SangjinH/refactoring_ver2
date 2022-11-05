/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright ⓒ2021 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package com.study.chapter1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static String statement(Invoice invoice, List<Play> plays) {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = String.format("청구내역 ( 고객명: %s )", invoice.customer);

        for (Performance perf : invoice.performances) {
            int thisAmount = 0;

            plays.get() perf.playID;


        }

        return result;
    }

    public static void main(String[] args) throws IOException, ParseException {
        ModelMapper mapper = new ModelMapper();
        Reader readPlays = new FileReader("/Users/hansangjin/Desktop/github/refactoring_ver2/src/main/java/com/study/chapter1/plays.json");
        Reader readInvoices = new FileReader("/Users/hansangjin/Desktop/github/refactoring_ver2/src/main/java/com/study/chapter1/invoices.json");

        JSONParser parser = new JSONParser();
        JSONObject parse = (JSONObject) parser.parse(readPlays);

        List<Play> plays = new ArrayList<>();
        for (Object o : parse.keySet()) {
            JSONObject jsonObject = (JSONObject) parse.get(o);
            String name = (String) jsonObject.get("name");
            String type = (String) jsonObject.get("type");
            plays.add(new Play(name, type));
        }

        JSONArray jsonArray = (JSONArray) parser.parse(readInvoices);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String customer = (String) jsonObject.get("customer");
        JSONArray performances = (JSONArray) jsonObject.get("performances");
        Invoice invoice = new Invoice();
        invoice.customer = customer;

        for (int i = 0; i < performances.size(); i++) {

            JSONObject jsonPerformance = (JSONObject) performances.get(i);
            String playID = (String) jsonPerformance.get("playID");
            Long audience = (Long) jsonPerformance.get("audience");
            Performance performance = new Performance(playID, Integer.parseInt(String.valueOf(audience)));

            invoice.performances.add(performance);
        }


        // STOPSHIP: 2022/11/05
        String statement = statement(invoice, plays);
        System.out.println("statement = " + statement);
    }
}
