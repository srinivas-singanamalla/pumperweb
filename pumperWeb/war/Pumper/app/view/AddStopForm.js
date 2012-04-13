Ext.define('Pumper.view.AddStopForm', {
    extend: 'Ext.panel.Panel',
    xtype: 'addStopForm',
    alias: 'widget.addStopForm',
    requires: [
        'Ext.form.*'
    ],

    initComponent: function() {
    	var formPanel = Ext.create('Ext.form.Panel', {
	    	
	    	title: 'Add a Stop',
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
	            name: 'stopName',
	            fieldLabel: 'Name',
	            value: 'Stop A66'
	        },
	        {
	            xtype: 'textfield',
	            name: 'stopDesc',
	            fieldLabel: 'Description',
	            value: 'Stop Desc'
	        },
	        {
	            xtype: 'textfield',
	            name: 'latitude',
	            fieldLabel: 'Latitude',
	            value: '33.07'
	        },
	        {
	            xtype: 'textfield',
	            name: 'longitude',
	            fieldLabel: 'Longitude',
	            value: '43.67'
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
