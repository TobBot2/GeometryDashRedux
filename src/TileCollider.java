import java.util.ArrayList;

public class TileCollider {

    public int pixelToGrid(float pixel, Level level){
        return (int) (pixel / level.TILE_SIZE);
    }
    public ArrayList<Tile> getCandidates(GameObject entity, Level level){
        ArrayList<Tile> result = new ArrayList<Tile>();

        int row;
        int startCol = pixelToGrid(entity.getLeft(),level);
        int endCol = pixelToGrid(entity.getRight(),level);

        if (entity.velY > 0){
            row = pixelToGrid(entity.getBottom(),level);
        }else if (entity.velY < 0){
            row = pixelToGrid(entity.getTop(), level);
        }else {
            return null;
        }

        for (int col = startCol; col <= endCol; col++){
            result.add(level.getTile(col,row));
        }

        return result;
    }
    public void checkY(GameObject entity, Level level){
        ArrayList<Tile> candidates = getCandidates(entity, level);

        if (candidates == null){
            return;
        }

        for (Tile candidate : candidates) {
            if (entity.bounds.overlaps(candidate.bounds)){
                if (candidate.getSolid()){
                    if (entity.velY > 0){
                        entity.setBottom(candidate.getTop());
                    } else if (entity.velY < 0){
                        entity.setTop(candidate.getBottom());
                    }
                    entity.setVelY(0);
                }
            }
        }
    }

}