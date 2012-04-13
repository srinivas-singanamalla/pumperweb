Ext.define('Pumper.view.RoutesTreePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'routesTreePanel',
    alias: 'widget.routesTreePanel',
    requires: [
        'Ext.tree.Panel'
    ],

    initComponent: function() {
    	var store = Ext.create('Ext.data.TreeStore', {
    	    root: {
    	        expanded: true,
    	        children: [
    	            { text: "Route A", leaf: false, cls: 'route', expanded: true, children: [{ text: "Stop CBD", expanded: true, leaf: false, cls: 'stop'}] },
    	            { text: "Route B", expanded: true, cls: 'route', children: [
    	                { text: "Stop 123", leaf: false, cls: 'stop' },
    	                { text: "Stop 567", leaf: false, cls: 'stop', expanded: true, children: [
    	                                                            { text: "Well BC", leaf: true, cls: 'wellhead' }, 
    	                                                            { text: "Tank 456889", leaf: true, cls: 'tank' }, 
    	                                                            { text: "Tank 78219", leaf: true, cls: 'tank' },
    	                                                            { text: "Gasmeter 219", leaf: true, cls: 'gasmeter' }
    	                                                            ]}
    	            ] },
    	            { text: "Route C", leaf: false, cls: 'route' }
    	        ]
    	    }
    	});

    	var treePanel = Ext.create('Ext.tree.Panel', {
//    	    title: 'Simple Tree',
    	    frame: false,
    	    width: 200,
    	    height: 350,
    	    store: store,
    	    rootVisible: false,
    	});

    	this.items = [treePanel];
    	this.callParent();
    }
});
    