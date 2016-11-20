/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var number_of_cols= 8,
    number_of_rows= 8,
    BLOCK_SIZE=100;
    
var BLOCK_COLOR_1 = '#9f7119',
	BLOCK_COLOR_2 = '#debf83',
	HIGHLIGHT_COLOR = '#fb0006';
var PIECE_PAWN = 0,
PIECE_CASTLE = 1,
PIECE_ROUKE = 2,
PIECE_BISHOP = 3,
PIECE_QUEEN = 4,
PIECE_KING = 5;

function draw()
{
    canvas = document.getElementById('chess');
    if(canvas.getContext)
    {
        ctx = canvas.getContext('2d');
        BLOCK_SIZE= canvas.height / number_of_rows;
        
    }
    
}
function drawBoard()
{
    for(iRowCounter = 0; iRowCounter < number_of_rows; iRowCounter++)
    {
        drawRow(iRowCounter); //draws Row
    }
    ctx.lineWidth = 3; // ctx is from canvas. setting width of the block to 3?
    //strokeRect draws a rectangle. parameters are (x,y,width,height)
    ctx.strokeRect(0, 0, number_of_rows * BLOCK_SIZE, number_of_cols * BLOCK_SIZE) // if number of columns is 8, and block size is lets say 4 inches. then total number of columns has to be 8*4
 
}
function drawRow(iRowCounter) // each row handled by the function drawRow
{
    for(iBlockCounter = 0; iBlockCounter < number_of_rows; iBlockCounter ++)
    {
        drawBlock(iRowCounter, iBlockCounter) //draws block
    }
}
function drawBlock(iRowCounter, iBlockCounter) // drawing all the rows and each block
{
    ctx.fillStyle = getBlockColor(iRowCounter, iBlockCounter); //fillStyle sets or returns the color used to fill the drawing
    
}
function getBlockColor(iRowCounter, iBlockCounter)
{
    var cStartColor;
    
    if (iRowCounter % 2)
    {
        cStartColor = (iBlockCounter % 2 ? BLOCK_COLOR_1 : BLOCK_COLOR_2);
    }
    else
    {
        cStartColor = (iBlockCounter % 2 ? BLOCK_COLOR_2 : BLOCK_COLOR_1);
    }
    return cStartColor;
    
}

defaultPos();

pieces = new Image();
pieces.src = 'pieces.png';
pieces.onload = drawPieces;
canvas.addEventListener('click', board_click, false);

function defaultPositions()
{
    json = 
    {
        "white": 
        [
            {
                "piece": PIECE_CASTLE,
                "row": 0,
                "col": 0,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_ROUKE,
                "row": 0,
                "col": 1,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_BISHOP,
                "row": 0,
                "col": 2,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_KING,
                "row": 0,
                "col": 3,
                "status": IN_PLAY
            },  
            {
                "piece": PIECE_QUEEN,
                "row": 0,
                "col": 4,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_BISHOP,
                "row": 0,
                "col": 5,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_ROUKE,
                "row": 0,
                "col": 6,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_CASTLE,
                "row": 0,
                "col": 7,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 1,
                "col": 0,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 1,
                "col": 1,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 1,
                "col": 2,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 1,
                "col": 3,
                "status": IN_PLAY
            },  
            {
                "piece": PIECE_PAWN,
                "row": 1,
                "col": 4,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 1,
                "col": 5,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 1,
                "col": 6,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 1,
                "col": 7,
                "status": IN_PLAY
            }
        ],
        "black": 
        [
            {
                "piece": PIECE_CASTLE,
                "row": 7,
                "col": 0,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_ROUKE,
                "row": 7,
                "col": 1,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_BISHOP,
                "row": 7,
                "col": 2,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_KING,
                "row": 7,
                "col": 3,
                "status": IN_PLAY
            },  
            {
                "piece": PIECE_QUEEN,
                "row": 7,
                "col": 4,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_BISHOP,
                "row": 7,
                "col": 5,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_ROUKE,
                "row": 7,
                "col": 6,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_CASTLE,
                "row": 7,
                "col": 7,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 6,
                "col": 0,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 6,
                "col": 1,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 6,
                "col": 2,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 6,
                "col": 3,
                "status": IN_PLAY
            },  
            {
                "piece": PIECE_PAWN,
                "row": 6,
                "col": 4,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 6,
                "col": 5,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 6,
                "col": 6,
                "status": IN_PLAY
            },
            {
                "piece": PIECE_PAWN,
                "row": 6,
                "col": 7,
                "status": IN_PLAY
            }
        ]       
    };
}

function drawPieces()
{
    drawTeamOfPieces(json.black, true);
    drawTeamOfPieces(json.white, false);
    
}

function drawTeamOfPieces(teamOfPieces, bBlack)
{
    var iPieceCounter; // counter
    
    for (iPieceCounter = 0; iPieceCounter < teamOfPieces.length; iPieceCounter++)
    {
        drawPiece(teamOfPieces[iPieceCounter], bBlack) // loop and draw each piece on canvas
    }
}
function drawPiece(curPiece, bBlack)
{
   var imageCoords = getImageCoords(curPiece.piece, bBlack)
   ctx.drawImage(pieces, imageCoords.x, imageCoords.y, 
   BLOCK_SIZE, BLOCK_SIZE, curPiece.col * BLOCK_SIZE, curPiece.row * BLOCK_SIZE, 
   curPiece.row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
}

function getImageCoords(pieceCode, bBlack)
{
    var imageCoords =
    {
          "x": pieceCode * BLOCK_SIZE,
          "y": (bBlack?0:BLOCK_SIZE)
    };
    
    return imageCoords;
}
