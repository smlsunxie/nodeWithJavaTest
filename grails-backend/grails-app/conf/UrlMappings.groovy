class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
		"/rest/$controller/$id?"{
			action = [GET: "show", PUT:"update", DELETE:"delete"]
			constraints {
				// apply constraints here
			}
		}
		"/rest/$controller"{
			action = [GET:"listAll", POST: "create"]
			constraints {
				// apply constraints here
			}
		}
	}
}
