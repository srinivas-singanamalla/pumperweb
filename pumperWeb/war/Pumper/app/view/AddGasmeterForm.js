Ext.define('Pumper.view.AddGasmeterForm', {
    extend: 'Ext.panel.Panel',
    xtype: 'addGasmeterForm',
    alias: 'widget.addGasmeterForm',
    requires: [
        'Ext.form.*'
    ],

    initComponent: function() {
    	
    	var formPanel = Ext.create('Ext.form.Panel', {
	    	
	    	title: 'Add a Gasmeter',
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
	            name: 'gasmeterName',
	            fieldLabel: 'Name',
	            value: 'Gasmeter A66'
	        },
	        {
	            xtype: 'textfield',
	            name: 'gasmeterDesc',
	            fieldLabel: 'Gasmeter Description',
	            value: 'Gasmeter Desc'
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
		this.items = [formPanel];
    	this.callParent();
    }
    
});
