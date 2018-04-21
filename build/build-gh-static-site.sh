#!/usr/bin/env bash
shadow-cljs release browser
rm -rf ./docs
mkdir -p docs/js/compiled
cp ./public/js/compiled/base.js ./docs/js/compiled/base.js
cp ./public/index.html ./docs/index.html
cp ./public/main.css ./docs/main.css