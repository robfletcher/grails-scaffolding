eventTestPhaseStart = { phase ->
	if (phase == "functional") {
		System.properties."geb.driver" = "firefox"
	}
}
