Ext.define('Pumper.view.AddWellheadForm', {
    extend: 'Ext.panel.Panel',
    xtype: 'addWellheadForm',
    alias: 'widget.addWellheadForm',
    requires: [
        'Ext.form.*'
    ],

    initComponent: function() {
    	
    	// The data store containing the list of states
    	var states = Ext.create('Ext.data.Store', {
    	    fields: ['abbr', 'name'],
    	    data : [
    	        {"abbr":"AL", "name":"Flowing"},
    	        {"abbr":"AK", "name":"Gas Lift"},
    	        {"abbr":"Hyd", "name":"Hydraulic"},
    	        {"abbr":"Inj", "name":"Injection"},
    	        {"abbr":"Pt", "name":"Platform"},
    	        {"abbr":"Pjr", "name":"Plunger"}
    	        //...
    	    ]
    	});
    	
    	// Create the combo box, attached to the states data store
    	var wellheadCombo = Ext.create('Ext.form.ComboBox', {
    	    fieldLabel: 'Choose Producing Method',
    	    store: states,
    	    queryMode: 'local',
    	    displayField: 'name',
    	    valueField: 'abbr'
    	});

    	
    	var formPanel = Ext.create('Ext.form.Panel', {
	    	
	    	title: 'Add a Wellhead',
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
	            name: 'wellheadName',
	            fieldLabel: 'Name',
	            value: 'Wellhead A66'
	        },
	        {
	            xtype: 'textfield',
	            name: 'wellheadDesc',
	            fieldLabel: 'Wellhead Description',
	            value: 'Wellhead Desc'
	        },
	        {
	        	fieldLabel: 'Producing Method',
	        	name: 'producingMethod',
	        	xtype: 'combo',
	    	    store: states,
	    	    queryMode: 'local',
	    	    displayField: 'name',
	    	    valueField: 'abbr'
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
