package ch20;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncodeExam {
	
	//URL에는 한글, 특수문자가 포함될 수 없음
	//URL encoding -> 한글, 특수문자를 URL형식으로 변환(변조)
	//URL decoding -> 엔코딩된 문자열을 처음 내용으로 복원(복조)
	
	public static void main(String[] args) {
		try {
			String str = "김철수";
			//URLEncoder.encode(엔코딩할 문자열, 형식)
			System.out.println(URLEncoder.encode(str, "utf-8"));
			//URLDecoder.decode(디코딩할 문자열, 형식)
			System.out.println(URLDecoder.decode("%EA%B9%80%EC%B2%A0%EC%88%98", "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
