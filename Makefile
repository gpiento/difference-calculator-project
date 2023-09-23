.DEFAULT_GOAL := build-run
.PHONY: build app

update:
	make -C app update

clean:
	make -C app clean

build:
	make -C app build

install:
	make -C app install

run-dist:
	make -C app run-dist

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

check-deps:
	make -C app check-deps

build-run:
	make -C app build-run

