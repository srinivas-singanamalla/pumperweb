Ext.define('Pumper.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires: [
               'Pumper.view.AddRouteForm', 
               'Pumper.view.RouteList',
               'Pumper.view.RoutesTreePanel',
               'Pumper.view.AddStopForm',
               'Pumper.view.AddWellheadForm',
               'Pumper.view.AddTankForm',
               'Pumper.view.AddGasmeterForm'
           ],
           layout: 'fit',
           
           initComponent: function() {
               this.items = {
                   	layout: {
                   		type: 'hbox',
                   		autoSize: true
                   	},
                   	autoScroll: true,
                	defaults: {
//                	    bodyStyle: 'padding:15px'
                	},
                	items: [{
                	    title: 'Route Configuration',
//                	    margins: '5 0 0 0',
//                	    cmargins: '5 5 0 0',
                	    collapsible: false,
                	    split: true,
                	    width: 175,
                	    xtype: 'routesTreePanel'
                	},{
                	    title: 'Main Content', 
                	    itemId: 'mainDetails',
                	    layout: 'card',
                	    
                	    margins: '5 0 0 0',
                	    items: [{
                	    	xtype: 'addRouteForm',
                	    	itemId: 'addRouteForm'
                	    },
                	    {
                	    	xtype: 'addGasmeterForm',
                	    	itemId: 'addGasmeterForm'
                	    },
                	    {
                	    	xtype: 'addTankForm',
                	    	itemId: 'addTankForm'
                	    },
                	    {
                	    	xtype: 'addWellheadForm',
                	    	itemId: 'addWellheadForm'
                	    },
                	    {
                	    	xtype: 'routeList',
                	    	itemId: 'routeList'
                	    }, 
                	    {
                	    	xtype: 'addStopForm',
                	    	itemId: 'addStopForm'
                	    }]
                	}]
                };
        
               this.callParent();
           }
       });