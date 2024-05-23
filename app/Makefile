.DEFAULT_GOAL := build-run
.PHONY: build app

PARAM1 := $(word 1,$(MAKECMDGOALS))
PARAM2 := $(word 2,$(MAKECMDGOALS))

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean installDist

run-dist: install
	@./build/install/app/bin/app $(PARAM1) $(PARAM2)

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

build-run: run-dist
