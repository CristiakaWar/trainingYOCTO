B = "${WORKDIR}/build"
D = "${WORKDIR}/image"

addtask do_configure before do_compile after do_unpack
do_configure () {
	mkdir -p "${B}"
	cd "${B}"
	cmake "${S}"
}

addtask do_complie before do_compile after do_configure
do_complie () {
	cd "${B}"
	make
}

addtask do_install before do_package after do_compile
do_install () {
	mkdir -p "${D}"
	cd "${B}"
	make DESTDIR="${D}" install
}

