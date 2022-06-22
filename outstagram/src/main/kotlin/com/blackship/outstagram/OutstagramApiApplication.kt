package com.blackship.outstagram

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OutstagramApiApplication

fun main(args: Array<String>) {
	runApplication<OutstagramApiApplication>(*args)
	// TODO: 사용자 정보를 가져와서 서버 측 정보를 조회해서
	// 회원가입 여부를 판단 -> 존재한다면 JWT 토큰 생성
}
