.DEFAULT_GOAL := build-run
.PHONY: build app

update:
	./gradlew useLatestVersions --warning-mode all

clean:
	./gradlew clean

build:
	./gradlew clean build installDist

install:
	./gradlew installDist

run-dist:
	@./app/build/install/app/bin/app

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

check-deps:
	./gradlew dependencyUpdates -Drevision=release

build-run: build install run-dist
