This is a sample project for prototyping changes to Grails scaffolding.

# To-Do

## Phase 1 - slightly slicker version of current Grails L&F

 * put required class (and HTML5 attribute) on the input itself rather than the container
 * date / time format for show & list pages

## Phase 2 - Re-design

 * FOUC prevention by fade-in with CSS transition
 * Form panel background #f7f7f7?
 * Hide null/blank values in show view

### Navigation

 * Include nav using SiteMesh
 * All controllers in nav?
 * Primary & secondary nav for controllers / actions?
 * Highlight active state

### Form inputs

 * use data-constraint-range="0..5" etc. so we can enhance and validate inputs based on constraints
 * use size attribute where appropriate
 * required="required" on mandatory fields
 * autofocus - 1st field in error or 1st in form
 * Radio groups for enums (use select when more than x values?)
 * Dates using type="date" with 3-field JS enhanced version?
 * Proper buttons
 * Is there a good alternative to multi-selects? (JS enhanced add & remove single selects?)

### Mobile

 * Test on iOS, Android, Blackberry, Kindle

### Accessibility

 * Error messages act as labels for form fields

### Enhanced experience

 * Light-box show, edit, create direct from list page
 * Functional tests to ensure non-JS and JS versions work consistently
 * Autcomplete:
    * aria roles where appropriate
    * autocomplete for enums & inList constraint?
    * autocomplete from entire list without typing
 * AJAX lists
    * can the pages slide in from right? Or left when using back button?

## Integration

 * Depend on resources plugin & export appropriate resource declarations
 * Depend on jQuery & jQuery-UI (can we make the latter optional & disable autocomplete without it?)
 * Does modernizr need a plugin?
 * Should the scaffolding enhancements be a plugin so they can be removed if using non-jQuery framework?

## Misc

 * Test the use of many-to-many on create as it might not work
