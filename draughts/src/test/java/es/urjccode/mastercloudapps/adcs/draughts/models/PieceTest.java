package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PieceTest {

    @Mock
    PieceProvider pieceProvider;

    @Test
    public void testGivenPieceWhenIsAdvancedThenNull(){
        assertNull(new Piece(Color.WHITE).validate(new Coordinate(5,0), new Coordinate(4,1), pieceProvider));
        assertNull(new Piece(Color.BLACK).validate(new Coordinate(2,1), new Coordinate(3,2), pieceProvider));
    }

    @Test
    public void testGivenPieceWhenNotIsAdvancedThenError(){
        assertEquals(Error.NOT_ADVANCED, new Piece(Color.WHITE).validate(new Coordinate(5,0), new Coordinate(6,1), pieceProvider));
        assertEquals(Error.NOT_ADVANCED, new Piece(Color.BLACK).validate(new Coordinate(2,1), new Coordinate(1,2), pieceProvider));
    }

    @Test
    public void testGivenPieceWhenIsNotDiagonalThenError() {
        assertEquals(Error.NOT_DIAGONAL, new Piece(Color.BLACK).validate(new Coordinate(2,1), new Coordinate(2,3), pieceProvider));
        assertEquals(Error.NOT_DIAGONAL, new Piece(Color.WHITE).validate(new Coordinate(5,0), new Coordinate(5,2), pieceProvider));
    }
}