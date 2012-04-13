Ext.define('Pumper.controller.RouteController', {
	extend: 'Ext.app.Controller',
	
	views: ['RouteList'],
	
	init: function() {
		this.control({
			'treepanel' : {
				render: this.onPanelRendered,
				
				itemclick: this.onItemClicked
			}
		});
	},
	
	onPanelRendered: function() {
		console.log("panel is rendered");
	},
	
	onItemClicked: function(view, record, item, index, e, eOpts) {
		console.log("item is clicked" + record.get('cls'));
		var panels = Ext.ComponentQuery.query('#mainDetails');
		
		Ext.each(panels, function(panel, index){
			
			if (index == 0) {
				var type = record.get('cls');
				var cmp, itemId;
				if (type == 'route') {
					itemId = 'addRouteForm';
				} else if (type == 'stop') {
					itemId = 'addStopForm';
				} else if (type == 'tank') {
					itemId = 'addTankForm';
				} else if (type == 'wellhead') {
					itemId = 'addWellheadForm';
				} else if (type == 'gasmeter') {
					itemId = 'addGasmeterForm';
				}
//				var item = Ext.getCmp(itemId);
				panel.getLayout().setActiveItem(itemId);
			}
			
		});
		
	}
});