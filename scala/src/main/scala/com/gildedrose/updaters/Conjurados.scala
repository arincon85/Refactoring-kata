package com.gildedrose.updaters

import com.gildedrose.Item

class Conjurados extends Updater{
  val default = new Default
  override def update(item: Item): Unit = {
    default.update(item)
    default.update(item)
    item.sellIn+=1
  }
}
