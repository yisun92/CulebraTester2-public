/**
 * CulebraTester
 * ## Snaky Android Test --- If you want to be able to try out the API using the **Execute** or **TRY** button from this page - an android device should be connected using `adb` - the server should have been started using `./culebratester2 start-server`  then you will be able to invoke the API and see the responses.
 *
 * OpenAPI spec version: 2.0.0
 *
 */
package io.swagger.server.models

import androidx.test.uiautomator.*


/**
 * Selector.
 *
 * @param checkable
 * @param clazz
 * @param clickable
 * @param depth
 * @param desc
 * @param pkg
 * @param res
 * @param scrollable
 * @param text
 * @param index
 * @param instance
 */
data class Selector(
    val checkable: Boolean? = null,
    val clazz: String? = null,
    val clickable: Boolean? = null,
    val depth: Int? = null,
    val desc: String? = null,
    val pkg: String? = null,
    val res: String? = null,
    val scrollable: Boolean? = null,
    val text: String? = null,
    val index: Int? = null,
    val instance: Int? = null
) {
    /**
     * Constructor from [UiObject2].
     */
    constructor(obj: UiObject2) : this(
        obj.isCheckable,
        obj.className,
        obj.isClickable,
        null,
        obj.contentDescription,
        obj.applicationPackage,
        obj.resourceName,
        obj.isScrollable,
        obj.text,
        null,
        null
    )

    /**
     * Constructor from [UiObject].
     */
    constructor(obj: UiObject) : this(
        obj.isCheckable,
        obj.className,
        obj.isClickable,
        null,
        obj.contentDescription,
        obj.packageName,
        null,
        obj.isScrollable,
        obj.text,
        null,
        null
    )

    /**
     * Returns a [BySelector] from Selector values
     */
    fun toBySelector(): BySelector {
        var bySelector: BySelector? = null

        checkable?.let { bySelector = bySelector?.checkable(checkable) ?: By.checkable(checkable) }
        clazz?.let { bySelector = bySelector?.clazz(clazz) ?: By.clazz(clazz) }
        clickable?.let { bySelector = bySelector?.clickable(clickable) ?: By.clickable(clickable) }
        depth?.let { bySelector = bySelector?.depth(depth) ?: By.depth(depth) }
        pkg?.let { bySelector = bySelector?.pkg(pkg) ?: By.pkg(pkg) }
        res?.let { bySelector = bySelector?.res(res) ?: By.res(res) }
        scrollable?.let {
            bySelector = bySelector?.scrollable(scrollable) ?: By.scrollable(scrollable)
        }
        text?.let { bySelector = bySelector?.text(text) ?: By.text(text) }
        // no index in BySelector
        // no instance in BySelector

        return bySelector!!
    }

    /**
     * Returns a [UiSelector] from Selector values.
     */
    fun toUiSelector(): UiSelector {
        val uiSelector = UiSelector()
        checkable?.let { uiSelector.checkable(checkable) }
        clazz?.let { uiSelector.className(clazz) }
        clickable?.let { uiSelector.clickable(clickable) }
        // no depth in UiSelector
        desc?.let { uiSelector.description(desc) }
        pkg?.let { uiSelector.packageName(pkg) }
        res?.let { uiSelector.resourceId(res) }
        scrollable?.let { uiSelector.scrollable(scrollable) }
        text?.let { uiSelector.text(text) }
        index?.let { uiSelector.index(index) }
        instance?.let { uiSelector.instance(instance) }

        return uiSelector
    }
}

