LESS_DIR = ./less
CSS_DIR = ./css

build:
	mkdir -p css
	lessc ${LESS_DIR}/engage.less > ${CSS_DIR}/engage.css
	lessc ${LESS_DIR}/app-posts.less > ${CSS_DIR}/app-posts.css
	lessc ${LESS_DIR}/app-case.less > ${CSS_DIR}/app-case.css
#	lessc ${LESS_DIR}/app-cases.less > ${CSS_DIR}/app-cases.css
	lessc ${LESS_DIR}/engage/overview.less > ${CSS_DIR}/app-engage-overview.css

node:
	mkdir -p css
	node compile-css.js 

watch:
	echo "Watching less files..."
	watchr -e "watch('less/.*\.less') { system 'make' }"

.PHONY: build node watch