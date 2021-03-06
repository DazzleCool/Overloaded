**Dev/Alpha/Beta Build**

* Code Cleanup
  * Dynamic Registration now in single place
  * Abstracted multi-armor rendering
* **New config entry for item texture size**. Before item texture size was tied to block resolution
* Config is now synced from server to client
* Config rewrite - physical files are the same though   
* Can now upload to Curse from command line (No mod changes)
* Forge version compiled against bumped up to 2611, should still be compatible with old versions

-------------------------------------------------------------------
**Version: 0.0.51 (RELEASE)**

* Enable ground speed modifier again. (Why can't flight and walk speed be done the same way... 
to many one offs for my liking, although I like how ground speed is done now, might make some more features out of it) 

-------------------------------------------------------------------
**Version: 0.0.50.1 (RELEASE)**

Hotfix to disable ground speed modifications

* jar is now signed (Because why not?)
* Disable ground speed modifications as the way I am currently doing it breaks servers

-------------------------------------------------------------------
**Version: 0.0.50 (RELEASE)**

Mostly quality of life changes / just getting the code base in a better state.

* Changelog will now be appended with previous info (pulled changelogs from last two days also)
* Added One Probe Integration for Item Interface / Player Interface / Hyper * Senders / Infinity Capacitor
* Linking Card will no longer forget the receiver when binding
* Nether Star Block is now Ore Dictionaryed to blockNetherStar 
* Code Cleanup using IDEA's automated tasks 
* Added charged variants of all powered items to creative menu.

Fixed:
* NPE if you somehow placed a Player Interface without setting the placer

-------------------------------------------------------------------
**Version: 0.0.49 (RELEASE)**

* Multi-Armor Settings Editor Implemented (+Recipe)
  * Right Click in GUI to change to more precise input mode for sliders.
* Multi-Armor Changes
  * Ground speed increase now uses power
    * Has config options for balancing
  * Flight has additional config options for balancing.
  * Max Speed limits are also in config
  * Most features can now be enabled/disabled via the settings editor.
  * Settings are saved to the helmet.
  
Fixed:
* Compressed Block now have blast resistance that corresponds to their hardness.

-------------------------------------------------------------------
**Version: 0.0.48 (BETA)**

Making build as beta as most likely will also push an update within next 24 hours to move settings GUI out of Dev Mode. All changes should be stable.

* Railgun implemented and moved out of dev only mode
  * Has recipe (that needs balancing)
    * Many config options for balancing
    * Sneak Scroll to change by Power Delta
      * Ctrl + Sneak to change by 100 * Power Delta
* Cleaned up Generic Data Storage to be more efficient and persist settings (used by armor and railgun)
* Cleaned up locale file as it had old entires

Dev Mode:
* Working on Settings GUI for the Multi-Armor