plugins {
    id("java")
}

group = "ru.mts.animal"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.1")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.postgresql:postgresql:42.1.4")
    implementation("org.liquibase:liquibase-core:4.28.0")
    implementation("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useJUnitPlatform()
}