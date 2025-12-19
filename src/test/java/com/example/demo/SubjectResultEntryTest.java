package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class SubjectResultEntryTest {


	
	@Test
	void testMain2() throws IOException {

        PrintStream originalErr = System.err;
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        try {
        	SubjectResultEntry.main(new String[] {});
        	String erMsg = "引数が正しくありません。" + 
        			"\r\n第１引数：入力用のCSVファイルのパス" + 
        			"\r\n第２引数：出力用のCSVファイルのパス";
            assertTrue(errContent.toString().contains(erMsg));
        } finally {
            // メッセージは元に戻す必要がある
            System.setErr(originalErr);
        }
	}
}
