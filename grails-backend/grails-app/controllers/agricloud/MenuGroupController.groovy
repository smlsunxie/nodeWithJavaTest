package agricloud

import grails.converters.JSON

class MenuGroupController {
    static scaffold = true
	
	
	
	
	def listAll = {
		def list = []
		MenuGroup.list().each { menuGroup->
			list << [
				id:menuGroup.id,
				menuId: menuGroup.menu.functionId,
				menuDes:menuGroup.menu.description,
				userGroupId: menuGroup.userGroup.userGroupId,
				userGroupDes: menuGroup.userGroup.description
			]
		}
		
		render (contentType: 'text/json') {
            [
				items: list,
				totalCount: list.size()
			]
		}

	}
	
	def create = {
		println request.JSON
		log.debug request.JSON
		def menu=Menu.findByFunctionId(request.JSON.menuId)
		def userGroup=UserGroup.findByUserGroupId(request.JSON.userGroupId)

		println menu
		println userGroup
		
		def item=new MenuGroup()
		item.menu=menu;
		item.userGroup=userGroup;
		
		item.save()
		
		if(item.hasErrors())
			println item.errors
		
        render (contentType: 'text/json') {
            [
                success: item.hasErrors()==false
            ]
        }

	}
	def update = {
		def menu=Menu.findByFunctionId(request.JSON.menuId)
		def userGroup=UserGroup.findByUserGroupId(request.JSON.userGroupId)
		def item=MenuGroup.findById(request.JSON.id)
		if (!item) {
			render (contentType: 'text/json') {
				[
					success: false
				]
			}
		}else {
		
			item.menu=menu
			item.userGroup=userGroup
			item.save()
			render (contentType: 'text/json') {
				[
					success: item.hasErrors()==false
				]
			}
		}
	}
	
	def delete={
		

		def item=MenuGroup.findById(params.id)

		if (!item) {
			render (contentType: 'text/json') {
				[
					success: false
				]
			}
		}else {
			item.delete();
			
			render (contentType: 'text/json') {
				[
					success: item.hasErrors()==false
				]
			}
		}
	}
}
