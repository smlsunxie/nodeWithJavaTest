package agricloud

class MenuGroup {

	UserGroup userGroup
	Menu menu
	
    static constraints = {
		menu unique:'userGroup'
    }
}
