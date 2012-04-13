Ext.define('Pumper.store.RouteStore', {
    extend: 'Ext.data.Store',
    model: 'Pumper.model.Route',
    
    constructor: function(config) {
    	this.callParent([config]);
    },
    
    proxy: {
        type: 'ajax',
        url: 'data/routes.json',
        reader: {
            type: 'json',
            root: 'users',
            successProperty: 'success'
        }
    },
    autoLoad: true
});