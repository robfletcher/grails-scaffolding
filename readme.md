This is a sample project for prototyping changes to Grails scaffolding.

# To-Do

## Phase 1 - slightly slicker version of current Grails L&F

 * .body { float: left; } is horrible and doesn't work on IE

## Phase 2 - Re-design

 * FOUC prevention by fade-in with CSS transition
 * Center content & apply some background

### Navigation

 * Include nav using SiteMesh
 * All controllers in nav?
 * Primary & secondary nav for controllers / actions?
 * Highlight active state

### Form inputs

 * Radio groups for enums (use select when more than x values?)
 * URL & email inputs when constraints present
 * Numerics using type="number", type="range"
 * JS enhance range with slider (where not natively supported)
 * Dates using type="date" with 3-field JS enhanced version?
 * Proper buttons
 * Is there a good alternative to multi-selects? (JS enhanced add & remove single selects?)
 * JS enhance single select as auto-completer

### Mobile

 * Test on iOS, Android, Blackberry

### Accessibility

 * WAI-ARIA roles
 * Error messages act as labels for form fields

### Enhanced experience

 * Sort & paginate list with AJAX (remember to support back button)
 * Light-box show, edit, create direct from list page
 * Functional tests to ensure non-JS and JS versions work consistently