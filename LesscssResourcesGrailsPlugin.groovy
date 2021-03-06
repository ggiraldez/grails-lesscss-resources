import org.grails.plugin.resource.ResourceService
import org.grails.plugin.resource.ResourceTagLib

class LesscssResourcesGrailsPlugin {
    // the plugin version
    def version = "0.6.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.5 > *"
    // the other plugins this plugin depends on
    def dependsOn = [resources:'1.0 > *']
    def loadAfter = ['resources']
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/*.gsp",
            "web-app/less/*"
    ]

    def author = "Paul Fairless"
    def authorEmail = ""
    def title = "Less CSS Resources"
    def description = '''\\
This plugin supports server-side compilation of .less CSS files to their .css counterparts.
'''

    // URL to the plugin's documentation
    def documentation = "https://github.com/paulfairless/grails-lesscss-resources"

    def doWithSpring = { ->
        // monkey-patch ResourceService and ResourceTagLib to support .less files
        ResourceService.DEFAULT_MODULE_SETTINGS['less'] = [
            disposition: 'head' 
        ]
        ResourceTagLib.SUPPORTED_TYPES['less'] = [
            type: "text/css", 
            rel: 'stylesheet/less', 
            media: 'screen, projection' 
        ]
    }
}
