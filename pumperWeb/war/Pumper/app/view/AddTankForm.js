Ext.define('Pumper.view.AddTankForm', {
    extend: 'Ext.panel.Panel',
    xtype: 'addTankForm',
    alias: 'widget.addTankForm',
    requires: [
        'Ext.form.*'
    ],

    initComponent: function() {
    	
    	var formPanel = Ext.create('Ext.form.Panel', {
	    	
	    	title: 'Add a Tank',
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
	            name: 'tankName',
	            fieldLabel: 'Name',
	            value: 'Tank A66'
	        },
	        {
	            xtype: 'textfield',
	            name: 'tankDesc',
	            fieldLabel: 'Tank Description',
	            value: 'Tank Desc'
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
