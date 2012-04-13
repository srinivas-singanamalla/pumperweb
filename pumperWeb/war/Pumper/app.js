Ext.Loader.setConfig({
	enabled: true
});
Ext.Loader.setPath({
    'Ext': 'extjs/src'
    
});

Ext.application({
    name: 'Pumper',    
//    requires: [
//               'Pumper.view.Viewport'
//           ],
    autoCreateViewport: true,
    models: ['Route'],    
    stores: ['RouteStore'],
    controllers: ['RouteController'],
    launch: function() {
        // This is fired as soon as the page is ready
    }
});
/*
Ext.application({
    name: 'Pumper',
    requires: [
               'Pumper.view.AddRouteForm'
           ],

    views: ['AddRouteForm'],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
        	layout:'border',
        	defaults: {
        	    collapsible: true,
        	    split: true,
        	    bodyStyle: 'padding:15px'
        	},
        	items: [{
        	    region: 'south',
        	    height: 150,
        	    minSize: 75,
        	    maxSize: 250,
        	    cmargins: '5 0 0 0'
        	},{
        	    title: 'Route Navigation',
        	    region:'west',
        	    margins: '5 0 0 0',
        	    cmargins: '5 5 0 0',
        	    width: 175,
        	    minSize: 100,
        	    maxSize: 250
        	},{
        	    title: 'Main Content',
        	    collapsible: false,
        	    region:'center',
        	    margins: '5 0 0 0',
        	    html: 'dadadadadad',
        	    layout: 'fit',
        	    items: [{
        	    	xtype: 'button'
        	    }]
        	}]
        });
    }
});*/