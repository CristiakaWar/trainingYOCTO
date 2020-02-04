PKGDIR = "${WORKDIR}/deploy"

addtask do_package before do_build after do_install
do_package() {
	mkdir - p "${PKGDIR}"
	tar caf "${PKGDIR}/tinyalsa.tar.gz" -C "${D}" "."
}
