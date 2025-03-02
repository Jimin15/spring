plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.inu.hackerton"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot 기본 스타터
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// API 문서화 (Swagger)
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// DB
	implementation("com.h2database:h2:2.2.224")

	// Hibernate (JPA ORM)
	implementation("org.hibernate:hibernate-core:6.2.7.Final")

	// JBoss Logging
	implementation("org.jboss.logging:jboss-logging:3.4.1.Final")

	// 테스트 의존성
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
