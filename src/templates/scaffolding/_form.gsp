<%=packageName%>
<% import grails.persistence.Event %>
<% import org.codehaus.groovy.grails.plugins.PluginManagerHolder %>
<%  excludedProps = Event.allEvents.toList() << 'version' << 'id' << 'dateCreated' << 'lastUpdated'
	persistentPropNames = domainClass.persistentProperties*.name
	props = domainClass.properties.findAll { persistentPropNames.contains(it.name) && !excludedProps.contains(it.name) }
	Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
	display = true
	required = false
	boolean hasHibernate = PluginManagerHolder.pluginManager.hasGrailsPlugin('hibernate')
	for (p in props) {
		if (hasHibernate) {
			cp = domainClass.constrainedProperties[p.name]
			display = (cp ? cp.display : true)
			required = (cp ? !(cp.propertyType in [boolean, Boolean]) && !cp.nullable && (cp.propertyType != String || !cp.blank) : false)
		}
		if (display) { %>
<div class="fieldcontain \${hasErrors(bean: ${propertyName}, field: '${p.name}', 'error')} ${required ? 'required' : ''}">
	<label for="${p.name}">
		<g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" />
		<% if (required) { %><span class="required-indicator">*</span><% } %>
	</label>
	${renderEditor(p)}
</div>
<%  }   } %>
