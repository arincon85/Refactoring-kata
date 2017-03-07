package com.gildedrose.updaters

import com.gildedrose.Item

/**
  * Created by arincon on 7/03/17.
  */
class Default extends Updater {
  override def update(item: Item): Unit = {
    decreaseQuality(item)
    decreaseSellIn(item)
    if (sellInDatePassed(item)) {
      decreaseQuality(item)
    }
  }

}
