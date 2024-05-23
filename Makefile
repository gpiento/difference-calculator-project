.DEFAULT_GOAL := build-run
.PHONY: build app

clean:
	make -C app clean

build:
	make -C app build

install:
	make -C app install

run-dist: install
	@./app/build/install/app/bin/app

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

build-run: run-dist
