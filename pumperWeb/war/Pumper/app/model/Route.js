Ext.define('Pumper.model.Route', {
    extend: 'Ext.data.Model',
    fields: ['email', 'name'],
    
    /*autoLoad: true,
    
    proxy: {
        type: 'ajax',
        url: 'app/data/routes.json',
        reader: {
            type: 'json',
            root: 'results'
        }
    },*/
    
    constructor: function(config) {
    	this.callParent([config]);
    }
});