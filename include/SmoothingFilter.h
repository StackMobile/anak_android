///////////////////////////////////////////////////////////////////////////////
// 
// (c) Visage Technologies AB 2002 - 2015  All rights reserved. 
// 
// This file is part of visage|SDK(tm). 
// Unauthorized copying of this file, via any medium is strictly prohibited. 
// 
// No warranty, explicit or implicit, provided. 
// 
// This is proprietary software. No part of this software may be used or 
// reproduced in any form or by any means otherwise than in accordance with
// any written license granted by Visage Technologies AB. 
// 
/////////////////////////////////////////////////////////////////////////////


#ifndef __SmoothingFilter_h__
#define __SmoothingFilter_h__

#ifdef VISAGE_STATIC
	#define VISAGE_DECLSPEC
#else

	#ifdef VISAGE_EXPORTS
		#define VISAGE_DECLSPEC __declspec(dllexport)
	#else
		#define VISAGE_DECLSPEC __declspec(dllimport)
	#endif

#endif


#include <cstdlib>

using namespace std;

namespace VisageSDK
{

// SmoothingFilter smooths floating or integer values by averaging
// up to 10 last values in the series. It can smooth up to 500 variables.
// The variables to be smoothed must be passed in the same order in each frame of the sequence.
// Before each frame, startFrame() is called. 
class VISAGE_DECLSPEC SmoothingFilter
{
public:
	// constructor
	SmoothingFilter();

	// destructor
	~SmoothingFilter();

	// reset the whole filter and start the new series
	void reset();

	// reset the variable counter and start a new frame in the series
	void startFrame();

// Pass a batch of data to the filter for smoothing. Data values are passed
// in data array, and the smoothing is performed directly on this array.
// n is the number of values in the array. w is the width of the smoothing filter,
// i.e. number of frames in the series that are averaged. w must be between 0
// and 10, otherwise function return without doing anything. 0 means no smoothing
// and function does nothing. Note that value of 1 does not make sense because
// only one value would be averaged.
	void smooth(float *data, int n, int w);

	void smooth_w(float *data, int n, int w);

	void smooth_w_time(float *data, int n, long t, int w, float H, float diffFloor = 0.0f, float diffCeil = 1000000.0f, float diffInit = 0.0f, float scale = 1.0f, int showVisualization = -1);

	// integer version of the smoothing function, all else is the same as in float version.
	void smooth(int *data, int n, int w);

	void smooth_w_time(int *data, int n, long t, int w, float H, float diffFloor = 0.0f, float diffCeil = 1000000.0f, float diffInit = 0.0f, float scale = 1.0f, int showVisualization = -1);

	void enable() {enabled = true;};
	void disable() {enabled = false;};

private:
	static const int FILTER_SIZE = 2000;
	static const int MAX_WINDOW_SIZE = 31; // max windows size in frames
	bool enabled; // smoothing filter can be disabled; while disabled, it does nothing
	int varCnt; //variable counter
	int nFrames; //frame counter
	float pv[FILTER_SIZE][MAX_WINDOW_SIZE]; //previous values of all variables
	int pvt[FILTER_SIZE][MAX_WINDOW_SIZE]; //times of previous values of all variables
	int pos[FILTER_SIZE]; // current storing position in array for each variable; it cycles within the MAX_WINDOW_SIZE positions
	bool initd[FILTER_SIZE]; // for each variable, a flag indicating if it is fully initialised, i.e. whether at least w values have been stored, where w is the width of the filter
	float maxDiffs[FILTER_SIZE];
	float minDiffs[FILTER_SIZE];
};

}
#endif // __SmoothingFilter_h__

