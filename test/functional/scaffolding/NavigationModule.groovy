package scaffolding

import geb.Module

class NavigationModule extends Module {

	static content = {
		links {
			$("a").groupBy {
				it.text()
			}
		}
	}

}
