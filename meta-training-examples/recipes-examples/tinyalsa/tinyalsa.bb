DESCRIPTION = "Dummy recipe for tinyalsa"

SRC_URI = "https://github.com/tinyalsa/tinyalsa.git"
SRCREV = "ea9da6e1b16c14408b3bc5323cdc7560366bb943"

S = "${WORKDIR}/git"

addtask do_fetch before do_configure
do_fetch () {
	git clone "${SRC_URI}" "${S}"
}

addtask do_unpack before do_configure after do_fetch
do_unpack () {
	cd "${S}"
	git checkout "${SRCREV}"
}

inherit cmake package_tar


