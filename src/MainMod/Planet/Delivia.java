package MainMod.Planet;

import mindustry.type.Planet;
import mindustry.type.SectorPreset; // Обязательный импорт
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import MainMod.DelivaricaBlocks;
import MainMod.Delivarica;
import arc.graphics.Color;

public class Delivia extends Planet {
    
    public static SectorPreset impact0039;

    public Delivia() {
        // Главное
        super("delivia", Delivarica.gertat, 1f, 2);
        this.localizedName = "Delivia";
        this.iconColor = DelivaricaBlocks.sandrock.mapColor; 
        
        this.accessible = true;
        this.alwaysUnlocked = true;
        this.visible = true;
        this.orbitSpacing = 6f;
        this.generator = new DeliviaGenerator();
        this.meshLoader = () -> new HexMesh(this, 6);
        
        // Атмосфера
        this.atmosphereColor = Color.valueOf("694035").a(0.25f); 
        this.atmosphereRadIn = 0.00f;
        this.atmosphereRadOut = 0.15f;
        this.hasAtmosphere = true;
        this.bloom = false;  

        // Облака
        this.cloudMeshLoader = () -> new MultiMesh(
            new HexSkyMesh(
                this,                                      
                51,                                  
                0.26f,                              
                0.17f,                             
                4,                              
                Color.valueOf("8f8f8f").a(0.45f),   
                2,                                
                0.45f,                        
                1f,                                   
                0.45f                              
                ));

        // Орбита
        this.rotateTime = 60f * 8f;   
        this.orbitTime = 60f * 60f * 4f; 

        // Высадка
        this.defaultCore = DelivaricaBlocks.coreReset;
        
        this.startSector = 10; 
        
        this.allowSectorInvasion = true;
        this.allowLaunchLoadout = false;
        this.clearSectorOnLose = true;
        this.allowLaunchToNumbered = true;

        impact0039 = new SectorPreset("impact-0039", this, 10) {{
            this.localizedName = "[white]The [coral]Impact [accent]<[white]0039[accent]>"; 
            
            this.difficulty = 4; 
            
            this.alwaysUnlocked = true; 
        }};
    }
}
