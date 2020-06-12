import java.util.ArrayList;

public class TileCollider {
    public int pixelToGrid(float pixel, Level level){
        return (int) (pixel / level.TILE_SIZE); 
    }
    public ArrayList<Tile> getYCandidates(GameObject entity, Level level){
        ArrayList<Tile> result = new ArrayList<Tile>();

        int row;
        int startCol = pixelToGrid(entity.bounds.getLeft(),level);
        int endCol = pixelToGrid(entity.bounds.getRight(),level);

        if (entity.velY > 0){
            row = pixelToGrid(entity.bounds.getBottom(),level);
        }else if (entity.velY < 0){
            row = pixelToGrid(entity.bounds.getTop(), level);
        }else {
            return null;
        }

        for (int col = startCol; col <= endCol; col++){
            result.add(level.getTile(col,row));
        }

        return result;
    }
    public ArrayList<Tile> getXCandidates(GameObject entity, Level level){
        ArrayList<Tile> result = new ArrayList<Tile>();

        int col;   
        int startRow = pixelToGrid(entity.bounds.getTop(),level);
        int endRow = pixelToGrid(entity.bounds.getBottom(),level);

        if (entity.velX > 0){
            col = pixelToGrid(entity.bounds.getRight(),level);
        }else if (entity.velX < 0){
            col = pixelToGrid(entity.bounds.getLeft(), level);
        }else {
            return null;
        }

        for (int row = startRow; row <= endRow; row++){
            result.add(level.getTile(col,row));
        }

        return result;
    }
    public void checkY(GameObject entity, Level level){
        ArrayList<Tile> candidates = getYCandidates(entity, level);

        if (candidates == null){
            return;
        }

        for (Tile candidate : candidates) {
            if (entity.bounds.overlaps(candidate.bounds)){
                if (candidate.getSolid()){
                    if (entity.velY > 0){
                        entity.setBottom(candidate.getTop()); // move entity
                    } else if (entity.velY < 0){
                        entity.setTop(candidate.getBottom()); // move entity
                    }
                    entity.setVelY(0);
                }
            }
        }
    }
    public void checkX(GameObject entity, Level level){
        ArrayList<Tile> candidates = getXCandidates(entity, level);

        if (candidates == null){
            return;
        }

        for (Tile candidate : candidates) {
            if (entity.bounds.overlaps(candidate.bounds)){
                if (candidate.getSolid()){
                    if (entity.velX > 0){
                        entity.setRight(candidate.getLeft()); // move entity
                    } else if (entity.velX < 0){
                        entity.setLeft(candidate.getRight()); // move entity
                    }
                    entity.setVelX(0);
                }
            }
        }
    }
    

}