Ext.define('Pumper.view.AddRouteForm', {
    extend: 'Ext.panel.Panel',
    xtype: 'addRouteForm',
    alias: 'widget.addRouteForm',
    requires: [
        'Ext.form.*'
    ],

    initComponent: function() {
    	this.callParent();
    },
    
    constructor : function(config) {
    	var formPanel = Ext.create('Ext.form.Panel', {
	    	
	    	title: 'Add a Route <span style ="color:red">(KNOTT-TUBB 42-K)</span>',
	    	//cls: 'chartpanel',
	    	
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
