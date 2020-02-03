DESCRIPTION = "Dummy recipe"

addtask do_printDescription before do_build before do_wait3 before do_wait5
do_printDescription () {
	echo "${DESCRIPTION}"
}

addtask do_wait3 after do_printDescription before do_build
do_wait3() {
	sleep 3
}

addtask do_wait5 after do_printDescription before do_build
do_wait5(){
	sleep 5
}

addtask do_build after do_wait3 after do_wait5
do_build(){
	echo "I'm done!"
}
