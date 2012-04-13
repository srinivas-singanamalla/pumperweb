/*Ext.define('Pumper.view.RouteList', {
    extend: 'Ext.panel.Panel',
    xtype: 'routeList',
    alias: 'widget.routeList',
    requires: [
        'Ext.form.*'
    ],

    initComponent: function() {
    	this.callParent();
    },
    
    constructor : function(config) {
    	var formPanel = Ext.create('Ext.form.Panel', {
	    	
	    	title: 'Route List <span style ="color:red">(KNOTT-TUBB 42-K)</span>',
	    	
	    	frame: false,
//	        title: 'Form Fields',
	        width: 350,
	        bodyPadding: 5,

	        fieldDefaults: {
	            labelAlign: 'left',
	            labelWidth: 90,
	            anchor: '100%'
	        },

	        items: [{
	            xtype: 'textfield',
	            name: 'route',
	            fieldLabel: 'Route',
	            value: 'Route 66'
	        }],
	        
	     // Reset and Submit buttons
	        buttons: [{
	            text: 'Reset',
	            handler: function() {
	                this.up('form').getForm().reset();
	            }
	        }, {
	            text: 'Submit',
	            formBind: true, //only enabled once the form is valid
	            disabled: true,
	            handler: function() {
	                var form = this.up('form').getForm();
	                if (form.isValid()) {
	                    form.submit({
	                        success: function(form, action) {
	                           Ext.Msg.alert('Success', action.result.msg);
	                        },
	                        failure: function(form, action) {
	                            Ext.Msg.alert('Failed', action.result.msg);
	                        }
	                    });
	                }
	            }
	        }]
	    });
		config.items = [formPanel];
		this.callParent([ config ]);
	}
});
*/
Ext.define('Pumper.view.RouteList', {
    extend: 'Ext.grid.Panel',
    xtype: 'routeList',
    alias: 'widget.routeList',
//    requires: ['Pumper.store.RouteStore'],
    
    store: 'RouteStore',
    title: 'Routes',
    hideHeaders: true,
    
    initComponent: function() {
    	/*
    	this.store = {
                fields: ['name', 'email'],
                data  : [
                    {name: 'Ed',    email: 'ed@sencha.com'},
                    {name: 'Tommy', email: 'tommy@sencha.com'}
                ]
            };
    	*/
        this.columns = [{
            dataIndex: 'name',
            flex: 1
        }];
        
        this.dockedItems = [{
            dock: 'bottom',
            xtype: 'toolbar',
            items: [{
                xtype: 'button',
                text: 'Settings',
                action: 'settings'
            }, {
                xtype: 'buttongroup',
                items: [{
                    text: 'By Date',
                    action: 'filter-date'
                }, {
                    text: 'ABC',
                    action: 'filter-name'
                }]
            }]
        }];
        
        this.callParent();
    }
});
