package com.gildedrose.updaters

import com.gildedrose.Item

/**
  * Created by arincon on 7/03/17.
  */
class AgedBrie extends Updater{
  override def update(item: Item): Unit = {
    decreaseSellIn(item)
    if (qualityLessThanMax(item)) {
      increaseQuality(item)
      if (sellInDatePassed(item)) {
        increaseQuality(item)
      }
    }
  }


}
