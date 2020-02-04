DESCRIPTION = "Dummy recipe for tinyalsa"

SRC_URI = "https://github.com/tinyalsa/tinyalsa.git"
S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
D = "${WORKDIR}/image"
PKDIR = "${WORKDIR}/deploy"

addtask do_fetch before do_configure
do_fetch () {
	git clone "${SRC_URI}" "${S}"
}

addtask do_configure
do_configure () {
	mkdir -p "${B}"
	cd "${B}"
	cmake "${S}"
}

addtask do_complie
do_complie () {
	cd "${B}"
	make
}

addtask do_install
do_install () {
	mkdir -p "${D}"
	cd "${B}"
	make DESTDIR="${D}" install
}

addtask do_package
do_package() {
	mkdir - p "${PKGDIR}"
	tar caf "${PKGDIR}/tinyalsa.tar.gz" -C "${D}" "."
}


addtask do_build
do_build () {
	echo "I'm done"
}
