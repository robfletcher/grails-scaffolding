This is a sample project for prototyping changes to Grails scaffolding.

# To-Do

## Bugs

 * Autocompleted results need to re-position horizontally if window resized
 * Text in elements added by JS needs to be i18nized

## Appearance

 * Blue mouseover highlight on list table looks wrong
 * Do messages with opaque full with bar like Songkick?
 * Do something more interesting with h1 tags?
 * Move mandatory indicator to right of form field (when not stacked)

## Browser issues

 * Appears to be a double margin on left of button bar inputs in IE6 & 7
 * Fonts look terrible in IE8 (oddly they look OK in IE6 & IE7)
 * Left padding on buttons is wrong on iPhone (might just be xcode emulator)
 * Use `@media screen and (monochrome)` to optimise rendering on Kindle
 * Numeric inputs don't work for decimal values in webkit browsers

## Data format

 * date / time format for show & list pages

## Forms

 * use `data-constraint-range="0..5"` etc. so we can enhance and validate inputs based on constraints
 * use size attribute where appropriate
 * Radio groups for enums (use select when more than x values?)
 * Dates using type="date" with 3-field JS enhanced version? Datepicker?

## Errors & messages

 * Display errors & messages in traditional position when no-js
 * tooltip inputs with error message (on focus?)

## Enhanced experience

 * History manipulation breaks if you go back to the list page after paginating/sorting [GitHub](https://github.com/robfletcher/grails-scaffolding/issues/#issue/2)
 * Light-box show, edit, create direct from list page
 * Functional tests to ensure non-JS and JS versions work consistently
 * Autocomplete:
    * indicate that it's an autocompleter
    * open autocomplete with focus? Mouse double-click?
    * suppress remove button on autocomplete for mandatory many-to-one
    * autocomplete for enums & inList constraint?
 * FOUC prevention by fade-in with CSS transition
 * Slicker version of confirmation on delete

## Navigation

 * Include nav using SiteMesh
 * All controllers in nav?
 * Primary & secondary nav for controllers / actions?
 * Highlight active state

## Mobile considerations

 * Test on iOS, Android, Blackberry, Kindle
 * Optimise inputs (e.g. not sure the autocomplete really works in iOS)

## Accessibility

## Integration

 * Depend on resources plugin & export appropriate resource declarations
 * Depend on jQuery & jQuery-UI (can we make the latter optional & disable autocomplete without it?)
 * Does modernizr need a plugin?
 * Should the scaffolding enhancements be a plugin so they can be removed if using non-jQuery framework?

## Misc

 * Test the use of many-to-many on create as it might not work
